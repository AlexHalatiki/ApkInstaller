import { WebPlugin } from '@capacitor/core';

import type { ApkInstallerPlugin } from './definitions';

export class ApkInstallerWeb extends WebPlugin implements ApkInstallerPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
