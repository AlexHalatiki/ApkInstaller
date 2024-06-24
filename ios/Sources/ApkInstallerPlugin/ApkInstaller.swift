import Foundation

@objc public class ApkInstaller: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
