# MI Issuing Tests

## How to run

`mvn clean verify -Denv=<environment> -Dplatform=<web platform>`

E.g.

`mvn clean verify -Denv=stage -Dplatform=chrome`

Optionally JBehave meta filter could be specified, e.g. `-Dmeta.filter="+SmokeTest"`

Or story name could be provided, e.g. `-DstoryName=program_setup_for_prepaid_card`