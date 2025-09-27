import { ApplicationConfig, provideBrowserGlobalErrorListeners, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideHttpClient } from '@angular/common/http';
import { provideApollo } from 'apollo-angular';
import { ApolloClient, InMemoryCache, HttpLink, NormalizedCacheObject, ApolloClientOptions } from '@apollo/client/core';


export const appConfig: ApplicationConfig = {
  
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    provideHttpClient(),
    provideApollo(createApollo)
  ]
};


function createApollo(): ApolloClientOptions<any> {
  return {
    link: new HttpLink({ uri: 'http://localhost:8080/graphql' }),
    cache: new InMemoryCache(),
  };
}
