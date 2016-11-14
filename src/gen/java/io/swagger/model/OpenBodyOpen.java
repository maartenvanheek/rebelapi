package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * OpenBodyOpen
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-14T12:30:06.878Z")
public class OpenBodyOpen   {
  private String initialDeposit = null;

  public OpenBodyOpen initialDeposit(String initialDeposit) {
    this.initialDeposit = initialDeposit;
    return this;
  }

   /**
   * Get initialDeposit
   * @return initialDeposit
  **/
  @ApiModelProperty(value = "")
  public String getInitialDeposit() {
    return initialDeposit;
  }

  public void setInitialDeposit(String initialDeposit) {
    this.initialDeposit = initialDeposit;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OpenBodyOpen openBodyOpen = (OpenBodyOpen) o;
    return Objects.equals(this.initialDeposit, openBodyOpen.initialDeposit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(initialDeposit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OpenBodyOpen {\n");
    
    sb.append("    initialDeposit: ").append(toIndentedString(initialDeposit)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

