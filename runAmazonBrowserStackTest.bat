call ./gradlew clean :cleanTest :test --tests com.amazon.testAmazon.amazonSearchForBookViaBrowserStack -Dos="Windows" -Dos_version="7" -Dbrowser="Chrome" -Dbrowser_version="70.0"
call ./gradlew clean :cleanTest :test --tests com.amazon.testAmazon.amazonSearchForBookViaBrowserStack -Dos="Windows" -Dos_version="10" -Dbrowser="Chrome" -Dbrowser_version="70.0"
call ./gradlew clean :cleanTest :test --tests com.amazon.testAmazon.amazonSearchForBookViaBrowserStack -Dos="Windows" -Dos_version="7" -Dbrowser="Firefox" -Dbrowser_version="70.0"
call ./gradlew clean :cleanTest :test --tests com.amazon.testAmazon.amazonSearchForBookViaBrowserStack -Dos="Windows" -Dos_version="10" -Dbrowser="Firefox" -Dbrowser_version="70.0"
