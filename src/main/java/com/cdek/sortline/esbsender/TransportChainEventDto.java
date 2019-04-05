package com.cdek.sortline.esbsender;

import com.cdek.commons.js.EsbEntityDto;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author s.krivozyatev 13.03.19 16:08
 */
@Getter
@Setter
public class TransportChainEventDto extends EsbEntityDto {

  public static final String MESSAGE_TYPE = "obj.transportChain";

  private String chainId;

  private List<TransportChainNodeEventDto> nodeList;
}
