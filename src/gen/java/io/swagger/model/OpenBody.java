package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.OpenBodyOpen;



/**
 * Data object encapsulating the transition parameters for the open transition
 **/

/**
 * Data object encapsulating the transition parameters for the open transition
 */
@ApiModel(description = "Data object encapsulating the transition parameters for the open transition")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-14T12:30:06.878Z")
public class OpenBody   {
  private OpenBodyOpen open = null;

  public OpenBody open(OpenBodyOpen open) {
    this.open = open;
    return this;
  }

   /**
   * Get open
   * @return open
  **/
  @ApiModelProperty(value = "")
  public OpenBodyOpen getOpen() {
    return open;
  }

  public void setOpen(OpenBodyOpen open) {
    this.open = open;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OpenBody openBody = (OpenBody) o;
    return Objects.equals(this.open, openBody.open);
  }

  @Override
  public int hashCode() {
    return Objects.hash(open);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OpenBody {\n");
    
    sb.append("    open: ").append(toIndentedString(open)).append("\n");
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

