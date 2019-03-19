package com.cdek.sortline.esbsender;

import com.cdek.commons.js.EsbEntityDto;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * @author s.krivozyatev 15.03.19 16:03
 */
@Getter
@Setter
public class MacroZoneEventDto extends EsbEntityDto {

  public static final String MESSAGE_TYPE = "obj.macrozone";
  /**
   * Идентификатор макрозоны
   */
  private UUID macroZoneUuid;

  /**
   * Головной офис макрозоны
   */
  private String office;

  /**
   * Наименование макрозоны
   */
  private String name;

  /**
   * Признак удаленной макрозоны
   */
  private Boolean deleted;

  public String toString() {
    return super.toString() + "\nMacroZoneEventDto(macroZoneUuid=" + this.getMacroZoneUuid() +
        ", office=" + this.getOffice() + ", name=" + this.getName() +
        ", deleted=" + this.getDeleted() + ")";
  }
}
