# Automation Framework
<img src="src/test/resources/img/browserstack.png" width="60" height="60" >
<img src="src/test/resources/img/sauce-labs.png" width="60" height="60" >
<img src="src/test/resources/img/cucumber.png" width="60" height="60" >

## Setup
* Clone the repo
* Install dependencies `mvn install`
* Set environment variables with your remote server, sauce-labs or browserstack username and access key (refer to Notes section)
* Update `*.conf.js` files inside the `src/test/resources/conf/` directory to update desired capabilities. (optional)

## Running your tests
* To run a single test,
  * Sauce-labs
    * run `mvn clean test -P sauce-labs`
  * Browserstack
    * run `mvn clean test -P browserstack`
* To run parallel tests 
  * Sauce-labs
    * run `mvn clean test -P sauce-labs-parallel`
  * Browserstack
    * run `mvn clean test -P browserstack-parallel`
* To run tests locally
  * run `mvn test -P local -Dbrowser=chrome`



## Notes
* You can view your test results on the 
  * [BrowserStack dashboard](https://www.browserstack.com/automate)
  * [Sauce-labs dashboard](https://app.eu-central-1.saucelabs.com/dashboard)
* You can export the environment variables for the Username and Access Key of your BrowserStack account. 

  ```
  export QA_USERNAME=<username> &&
  export QA_ACCESS_KEY=<access-key>
  ```

## Addtional Resources
* [WebDriver](https://www.selenium.dev/documentation/webdriver/)
* [Selenium Grid](https://www.selenium.dev/documentation/grid/)
* [Cucumber Documentation](https://cucumber.io/docs/cucumber/)
* [Documentation for writing Automate test scripts in Java](https://www.browserstack.com/automate/java)
* [Customizing your tests on BrowserStack](https://www.browserstack.com/automate/capabilities)
* [Browsers & mobile devices for selenium testing on BrowserStack](https://www.browserstack.com/list-of-browsers-and-platforms?product=automate)
* [Using REST API to access information about your tests via the command-line interface](https://www.browserstack.com/automate/rest-api)

## Cucumber Supported Properties
* cucumber.ansi-colors.disabled=  # true or false. default: false
* cucumber.execution.dry-run=     # true or false. default: false
* cucumber.execution.limit=       # number of scenarios to execute (CLI only).
* cucumber.execution.order=       # lexical, reverse, random or random:[seed] (CLI only). default: lexical
* cucumber.execution.wip=         # true or false. default: false.
* cucumber.features=              # comma separated paths to feature files. example: path/to/example.feature, path/to/other.feature
* cucumber.filter.name=           # regex. example: .*Hello.*
* cucumber.filter.tags=           # tag expression. example: @smoke and not @slow
* cucumber.glue=                  # comma separated package names. example: com.example.glue
* cucumber.plugin=                # comma separated plugin strings. example: pretty, json:path/to/report.json
* cucumber.object-factory=        # object factory class name. example: com.example.MyObjectFactory
* cucumber.snippet-type=          # underscore or camelcase. default: underscore

`mvn clean test -P sauce-labs -Dcucumber.filter.tags="@Smoke"` 