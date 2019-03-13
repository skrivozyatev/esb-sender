package com.cdek.sortline.esbsender;

import com.cdek.commons.js.EsbEntityDto;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TransportChain extends EsbEntityDto {

  public static final String MESSAGE_TYPE = "obj.transportChain";

  /**
   * Идентификатор цепочки
   */
  private String chainId;

  /**
   * Офис
   */
  private String office;

  /**
   * Следующий офис
   */
  private String nextOffice;

  /**
   * Минимальная дата прибытия
   */
  private Date minDate;

  /**
   * Максимальная дата прибытия
   */
  private Date maxDate;
}
