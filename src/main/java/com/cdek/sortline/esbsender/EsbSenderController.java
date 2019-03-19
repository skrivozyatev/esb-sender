package com.cdek.sortline.esbsender;

import com.cdek.commons.js.EsbEntityDto;
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
    return send(transportChain, TransportChainEventDto.MESSAGE_TYPE);
  }

  @RequestMapping(value = "/send/macroZone", method = RequestMethod.POST, produces = "application/json")
  public String sendMacroZone(@RequestBody MacroZoneEventDto macroZoneEventDto) {
    return send(macroZoneEventDto, MacroZoneEventDto.MESSAGE_TYPE);
  }

  private <T extends EsbEntityDto> String send(T esbEntityDto, String messageType) {
    EsbMessage<T> esbMessage = new EsbMessage<>();
    esbEntityDto.setUuid(UUID.randomUUID());
    esbEntityDto.setTimestamp(ZonedDateTime.now(ZoneOffset.UTC).toInstant().toEpochMilli());
    esbMessage.setEntity(esbEntityDto);
    esbMessage.setMessageType(messageType);
    esbMessage.setRoutingKey("");
    esbClient.publishObject(esbMessage);
    return esbEntityDto.toString();
  }
}
