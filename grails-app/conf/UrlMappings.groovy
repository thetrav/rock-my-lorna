class UrlMappings {

	static mappings = {

      "/lorna/view/$fileName" (controller: "data", action: "view")

		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
