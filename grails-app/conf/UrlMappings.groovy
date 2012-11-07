class UrlMappings {

	static mappings = {
      "/image/$fileName" (controller: "data", action: "view")
      "/gallery" (controller: "data", action: "index")

		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
