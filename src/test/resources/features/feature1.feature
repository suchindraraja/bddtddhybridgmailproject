Feature: Title test

@smoketest
Scenario: Validate gmail title test
Given launch site
Then title should be "Gmail" for homepage
When close site