import {Inject, Injectable} from '@angular/core';
import * as uriTemplates from 'uri-templates';

import {APP_CONFIG} from './app-config';

@Injectable()
export class UriBuilderService {

    private baseUrlConfig;

    private static fillAndCheckUrl(url: string, urlParams?: any): string {
      const uri = urlParams ? uriTemplates(url).fill(urlParams) : url;
      if (uri.lastIndexOf('/') === uri.length - 1) {
        return uri.substring(0, uri.length - 1);
      }
      return  uri;
    }

    constructor(@Inject(APP_CONFIG) private config: any) {
      this.baseUrlConfig = `${this.config.scheme}://${this.config.serverName}:${this.config.port}/${this.config.baseUrl}/${this.config.apiPath}/`;
    }

    public buildUrl(url: string, urlParams?: any) {
      return this.baseUrlConfig + UriBuilderService.fillAndCheckUrl(url, urlParams);
    }
}
