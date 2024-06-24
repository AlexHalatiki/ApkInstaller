export interface ApkInstallerPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
