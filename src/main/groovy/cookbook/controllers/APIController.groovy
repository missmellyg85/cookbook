package cookbook.controllers

import org.json.JSONObject
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

class APIController {

    @RequestMapping(value = "/api/public", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    String publicEndpoint() {
        return new JSONObject()
                .put("message", "All good. You DO NOT need to be authenticated to call /api/public.")
                .toString()
    }

    @RequestMapping(value = "/api/private", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    String privateEndpoint() {
        return new JSONObject()
                .put("message", "All good. You can see this because you are Authenticated.")
                .toString()
    }

    @RequestMapping(value = "/api/private-scoped", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    String privateScopedEndpoint() {
        return new JSONObject()
                .put("message", "All good. You can see this because you are Authenticated with a Token granted the 'read:messages' scope")
                .toString()
    }
}
