package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Data object encapsulating the transition parameters for the book transition
 **/

/**
 * Data object encapsulating the transition parameters for the book transition
 */
@ApiModel(description = "Data object encapsulating the transition parameters for the book transition")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-07T08:05:00.767Z")
public class BookBody   {
  private Object book = null;

  public BookBody book(Object book) {
    this.book = book;
    return this;
  }

   /**
   * Get book
   * @return book
  **/
  @ApiModelProperty(required = true, value = "")
  public Object getBook() {
    return book;
  }

  public void setBook(Object book) {
    this.book = book;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookBody bookBody = (BookBody) o;
    return Objects.equals(this.book, bookBody.book);
  }

  @Override
  public int hashCode() {
    return Objects.hash(book);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookBody {\n");
    
    sb.append("    book: ").append(toIndentedString(book)).append("\n");
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

