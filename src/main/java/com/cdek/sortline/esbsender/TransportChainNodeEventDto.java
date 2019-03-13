package com.cdek.sortline.esbsender;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * @author s.krivozyatev 13.03.19 16:09
 */
@Getter
@Setter
public class TransportChainNodeEventDto {

  /**
   * Идентификатор цепочки
   */
  private String chainId;

  /**
   * Офис
   */
  private String office;

  /**
   * Тип транспорта
   */
  private Integer transportType;

  /**
   * Следующий офис
   */
  private String nextOffice;

  /**
   * Офис назначения
   */
  private String recipientOffice;

  /**
   * Минимальная дата прибытия
   */
  private Date minDate;

  /**
   * Максимальная дата прибытия
   */
  private Date maxDate;
}
