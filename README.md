# Barcode-Scanner
A barcode scanner library with example. Based on Google Vision and androidhive's ravi8x's library for barcode scanner.

## How to use
Add jitpack to project level dependencies.
```gradle
allprojects {
    repositories {
        // other dependencies
        maven { url 'https://jitpack.io' }
    }
}
```

Add latest version of the barcode scanner to module level dependencies.
```gradle
dependencies {
  implementation 'com.github.Walshf0411:Barcode-Scanner:latest_release_here'
}
``` 
Create a new Activity and a fragment to your layout with the name 'com.walshfernandes.barcodescanner.BarcodeReader' activity. Options such as use_flash with the app prefix can be used here.
```xml
<fragment
    android:id="@+id/barcode_scanner"
    android:name="com.walshfernandes.barcodescanner.BarcodeReader"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:auto_focus="true"/>
```
In the java file that houses the above layout implement Barcoder.BarcodeReaderListener. Implement the methods according to the purpose of your project.
```java
public class ScannerActivity extends AppCompatActivity implements BarcodeReader.BarcodeReaderListener {
  @Override
  public void onScanned(Barcode barcode) {}
  
  @Override
  public void onScannedMultiple(List<Barcode> barcodes) {}
  
  @Override
  public void onBitmapScanned(SparseArray<Barcode> sparseArray) {}

  @Override
  public void onScanError(String errorMessage) {}

  @Override
  public void onCameraPermissionDenied() {}
}
```
Additionally you can add an overlay to the scanner by adding a ScannerOverlay tag in your layout file.
```xml
<com.walshfernandes.barcodescanner.ScannerOverlay
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#44000000"
    app:line_color="#7323DC"
    app:line_speed="6"
    app:line_width="4"
    app:square_height="200"
    app:square_width="200" />
```

