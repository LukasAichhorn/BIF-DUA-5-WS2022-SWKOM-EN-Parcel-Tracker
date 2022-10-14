package at.fhtw.swen3.persistence;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * TransferwarehouseAllOf
 */

@JsonTypeName("transferwarehouse_allOf")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-14T15:32:51.812001Z[Etc/UTC]")
public class TransferwarehouseAllOf {

  @JsonProperty("regionGeoJson")
  private String regionGeoJson;

  @JsonProperty("logisticsPartner")
  private String logisticsPartner;

  @JsonProperty("logisticsPartnerUrl")
  private String logisticsPartnerUrl;

  public TransferwarehouseAllOf regionGeoJson(String regionGeoJson) {
    this.regionGeoJson = regionGeoJson;
    return this;
  }

  /**
   * GeoJSON (https://geojson.org/) of the area covered by the logistics partner.
   * @return regionGeoJson
  */
  
  @Schema(name = "regionGeoJson", description = "GeoJSON (https://geojson.org/) of the area covered by the logistics partner.", required = false)
  public String getRegionGeoJson() {
    return regionGeoJson;
  }

  public void setRegionGeoJson(String regionGeoJson) {
    this.regionGeoJson = regionGeoJson;
  }

  public TransferwarehouseAllOf logisticsPartner(String logisticsPartner) {
    this.logisticsPartner = logisticsPartner;
    return this;
  }

  /**
   * Name of the logistics partner.
   * @return logisticsPartner
  */
  
  @Schema(name = "logisticsPartner", description = "Name of the logistics partner.", required = false)
  public String getLogisticsPartner() {
    return logisticsPartner;
  }

  public void setLogisticsPartner(String logisticsPartner) {
    this.logisticsPartner = logisticsPartner;
  }

  public TransferwarehouseAllOf logisticsPartnerUrl(String logisticsPartnerUrl) {
    this.logisticsPartnerUrl = logisticsPartnerUrl;
    return this;
  }

  /**
   * BaseURL of the logistics partner's REST service.
   * @return logisticsPartnerUrl
  */
  
  @Schema(name = "logisticsPartnerUrl", description = "BaseURL of the logistics partner's REST service.", required = false)
  public String getLogisticsPartnerUrl() {
    return logisticsPartnerUrl;
  }

  public void setLogisticsPartnerUrl(String logisticsPartnerUrl) {
    this.logisticsPartnerUrl = logisticsPartnerUrl;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransferwarehouseAllOf transferwarehouseAllOf = (TransferwarehouseAllOf) o;
    return Objects.equals(this.regionGeoJson, transferwarehouseAllOf.regionGeoJson) &&
        Objects.equals(this.logisticsPartner, transferwarehouseAllOf.logisticsPartner) &&
        Objects.equals(this.logisticsPartnerUrl, transferwarehouseAllOf.logisticsPartnerUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(regionGeoJson, logisticsPartner, logisticsPartnerUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransferwarehouseAllOf {\n");
    sb.append("    regionGeoJson: ").append(toIndentedString(regionGeoJson)).append("\n");
    sb.append("    logisticsPartner: ").append(toIndentedString(logisticsPartner)).append("\n");
    sb.append("    logisticsPartnerUrl: ").append(toIndentedString(logisticsPartnerUrl)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

