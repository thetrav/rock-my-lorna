// Place your Spring DSL code here
beans = {
   simpleRemoteServiceCache(
      org.springframework.cache.ehcache.EhCacheFactoryBean) {
      timeToLive = 3600 // life span in seconds
   }
}
