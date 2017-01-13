 <form class="form-horizontal">
    <fieldset>
      <div id="legend" class="">
        <legend class="">CodeGenerator</legend>
      </div>
    <div class="control-group">
          <!-- Text input-->
          <label class="control-label" for="input01">IP Address</label>
          <div class="controls">
            <input type="text" name="ip" placeholder="127.0.0.1" class="input-xlarge">
            <p class="help-block">IP地址不能为空！</p>
          </div>
        </div>
    <div class="control-group">
          <!-- Text input-->
          <label class="control-label" for="input01">Port</label>
          <div class="controls">
            <input type="text" name="port" placeholder="3306" class="input-xlarge">
            <p class="help-block">数据库端口不能为空！</p>
          </div>
        </div>
    <div class="control-group">
          <!-- Text input-->
          <label class="control-label" for="input01">User Name</label>
          <div class="controls">
            <input type="text" name="userName" placeholder="root" class="input-xlarge">
            <p class="help-block">用户名不能为空！</p>
          </div>
        </div>
    <div class="control-group">
          <!-- Text input-->
          <label class="control-label" for="input01">Password</label>
          <div class="controls">
            <input type="text" name="password" placeholder="Password" class="input-xlarge">
            <p class="help-block">数据库密不能为空！</p>
          </div>
        </div><div class="control-group">
          <label class="control-label">Database Type</label>
          <!-- Multiple Checkboxes -->
          <div class="controls">
      <!-- Inline Checkboxes -->
      <label class="checkbox inline">
        <input type="checkbox" name="databaseType" value="MySQL">
        MySQL
      </label>
      <label class="checkbox inline">
        <input type="checkbox" name="databaseType" value="PostgrelSQL">
        PostgrelSQL
      </label>
      <label class="checkbox inline">
        <input type="checkbox" name="databaseType" value="Oracle">
        Oracle
      </label>
  </div>
        </div>
    <div class="control-group">
          <!-- Text input-->
          <label class="control-label" for="input01">Database Name/SID</label>
          <div class="controls">
            <input type="text" name="databaseName" placeholder="mysql" class="input-xlarge">
            <p class="help-block">包路径不能为空！</p>
          </div>
        </div>

		<div class="control-group">

          <!-- Text input-->
          <label class="control-label" for="input01">author</label>
          <div class="controls">
            <input type="text" name="author" placeholder="author" class="input-xlarge">
            <p class="help-block"></p>
          </div>
        </div>
    </fieldset>
  </form>
