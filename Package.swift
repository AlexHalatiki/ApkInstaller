// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorInstallApkPlugin",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "CapacitorInstallApkPlugin",
            targets: ["ApkInstallerPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "ApkInstallerPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/ApkInstallerPlugin"),
        .testTarget(
            name: "ApkInstallerPluginTests",
            dependencies: ["ApkInstallerPlugin"],
            path: "ios/Tests/ApkInstallerPluginTests")
    ]
)