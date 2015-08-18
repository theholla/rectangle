import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      //makes a root page
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //save the info from user in to length and width variables
    get("/rectangle", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int length = Integer.parseInt(request.queryParams("length"));
      int width = Integer.parseInt(request.queryParams("width"));

      //instantiating a rectangle object with the variables we just created
      Rectangle myRectangle = new Rectangle(length, width);
      model.put("myRectangle", myRectangle);

      model.put("template", "templates/rectangle.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


  }
}
