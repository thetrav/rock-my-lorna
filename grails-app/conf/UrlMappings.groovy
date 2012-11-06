class UrlMappings {

	static mappings = {
      "/image/$fileName" (controller: "data", action: "view")

		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
