import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';
import { ApolloClient, HttpLink, InMemoryCache } from '@apollo/client';


const client = new ApolloClient({
  link: new HttpLink({ uri: 'http://localhost:8080/graphql' }), // URL de tu backend
  cache: new InMemoryCache(),
});



bootstrapApplication(App, appConfig)
  .catch((err) => console.error(err));
