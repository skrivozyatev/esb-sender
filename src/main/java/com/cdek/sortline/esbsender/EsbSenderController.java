package com.cdek.sortline.esbsender;

import com.cdek.queue.EsbClient;
import com.cdek.queue.rabbit.EsbMessage;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.UUID;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author s.krivozyatev 20.02.19 14:40
 */
@RestController
public class EsbSenderController {

  private final EsbClient esbClient;

  public EsbSenderController(EsbClient esbClient) {
    this.esbClient = esbClient;
  }

  @RequestMapping(value = "/send/transportchain", method = RequestMethod.POST, produces = "application/json")
  public String sendTransportChain(@RequestBody TransportChainEventDto transportChain) {
    EsbMessage<TransportChainEventDto> esbMessage = new EsbMessage<>();
    transportChain.setUuid(UUID.randomUUID());
    transportChain.setTimestamp(ZonedDateTime.now(ZoneOffset.UTC).toInstant().toEpochMilli());
    esbMessage.setEntity(transportChain);
    esbMessage.setMessageType(TransportChainEventDto.MESSAGE_TYPE);
    esbMessage.setRoutingKey("");
    esbClient.publishObject(esbMessage);
    return transportChain.toString();
  }
}
