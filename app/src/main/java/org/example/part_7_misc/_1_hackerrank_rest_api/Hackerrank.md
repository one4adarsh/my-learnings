# Hackerrank REST API design problems

> Steps in general

- given function
  - define `final String EndPoint = `
  - handle simple logic
  - create a new function to make actual api calls
- new function
  - import
    - `import java.net.*;`
    - `import javax.script.*;`
  - arguments: url
    - and others depending upon the situation
  - url
  - httpURLConnection
    - set RequestMethod, ConnectTimeout, ReadTimeout, RequestProperty
    - get ResponseCode
  - InputStream
  - BufferReader
  - String responseline
  - StringBuffer responseContent
  - read
  - close buffer reader
  - close connection
  - `String script = "var obj = " + responseContent + ";";`
  - `script += "...";` can add javascript code like this
  - ScriptEngine engine
    - try
      - engine.eval
    - catch
      - ScriptException
  - check `ee.get("total") == null`
    - if yes: throw error
  - java business logic
    - `int totalPages = (int) ee.get("total_pages");`
    