# Test Results

TODO 11: Run each test case against `src/support.html`. Fill in **Actual result** with what happened (for a submit, paste everything after the `?` in the address bar) and **Status** with Pass or Fail.

Before each test case, refresh the page without a query string (or click **Clear**) so it starts from its default values.

| ID | Type | Steps | Expected result | Actual result | Status |
|---|---|---|---|---|---|
| TC01 | Positive | Enter the standard test data (see README), choose **High**, tick the updates box, click **Submit Request** | `name=Ada+Lovelace&email=ada%40example.com&category=technical&priority=high&description=Export+fails&updates=yes&account=A-1042` | | |
| TC02 | Positive | Enter the standard test data, leave priority at its default, leave the updates box unticked, click **Submit Request** | `name=Ada+Lovelace&email=ada%40example.com&category=technical&priority=normal&description=Export+fails&account=A-1042` | | |
| TC03 | Negative | Enter the standard test data, but leave Category on **Choose one**, click **Submit Request** | Not submitted; the browser flags the Category field | | |
| TC04 | Negative | Enter the standard test data, but change Email to `ada`, click **Submit Request** | Not submitted; the browser flags the Email field | | |
| TC05 | Negative | Leave every field at its default, click **Submit Request** | Not submitted; the browser flags the first required field (Full name) | | |
| TC06 | Positive | Enter the standard test data, click **Preview** | Nothing happens; the URL doesn't change | | |
| TC07 | Positive | Enter the standard test data, choose **High**, click **Clear** | All typed values are emptied; Category returns to **Choose one**; priority returns to **Normal**; Account ID still reads `A-1042` | | |
