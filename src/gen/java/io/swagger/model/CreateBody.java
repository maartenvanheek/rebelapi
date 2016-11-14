package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.CreateBodyCreate;



/**
 * Data object encapsulating the transition parameters for the create transition
 **/

/**
 * Data object encapsulating the transition parameters for the create transition
 */
@ApiModel(description = "Data object encapsulating the transition parameters for the create transition")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-14T12:30:06.878Z")
public class CreateBody   {
  private CreateBodyCreate create = null;

  public CreateBody create(CreateBodyCreate create) {
    this.create = create;
    return this;
  }

   /**
   * Get create
   * @return create
  **/
  @ApiModelProperty(value = "")
  public CreateBodyCreate getCreate() {
    return create;
  }

  public void setCreate(CreateBodyCreate create) {
    this.create = create;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateBody createBody = (CreateBody) o;
    return Objects.equals(this.create, createBody.create);
  }

  @Override
  public int hashCode() {
    return Objects.hash(create);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateBody {\n");
    
    sb.append("    create: ").append(toIndentedString(create)).append("\n");
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

