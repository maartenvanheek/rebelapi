package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Data object encapsulating the transition parameters for the block transition
 **/

/**
 * Data object encapsulating the transition parameters for the block transition
 */
@ApiModel(description = "Data object encapsulating the transition parameters for the block transition")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-07T08:05:00.767Z")
public class BlockBody   {
  private Object block = null;

  public BlockBody block(Object block) {
    this.block = block;
    return this;
  }

   /**
   * Get block
   * @return block
  **/
  @ApiModelProperty(required = true, value = "")
  public Object getBlock() {
    return block;
  }

  public void setBlock(Object block) {
    this.block = block;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BlockBody blockBody = (BlockBody) o;
    return Objects.equals(this.block, blockBody.block);
  }

  @Override
  public int hashCode() {
    return Objects.hash(block);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BlockBody {\n");
    
    sb.append("    block: ").append(toIndentedString(block)).append("\n");
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

