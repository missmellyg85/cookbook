package cookbook.controllers

import cookbook.domain.Recipe
import geb.Browser
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/soccer")
class SoccerController {

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllRecipes() {
        "hi"
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    def index() {
        def stats = [:]
        Browser.drive {
            go "http://fantasy.mlssoccer.com/"

            $("#gigya_login .ui-link", text: "Login").click()

            $("#gigya-modal-plugin-container-showScreenSet_social_0_p0 div", title: "Twitter").click()

            def window = Browser.getAvailableWindows()

            println window.dump()

//            $("form#oauth_form").with {
//                username = "skcwillie"
//                password = 'Rw000629779!'
//                login().click()
//            }
        }
    }
}
