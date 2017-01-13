<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="include-head.jsp"%>
</head>
<body>






	<script id="entry-template1" type="text/x-handlebars-template">
{{permalink}}
{{#each comments}}
  <p>{{this}}</p>
<a>{{../permalink}}</a>
 {{@index}}: {{this}}

  {{#with author}}
  <h2>By {{firstName}} {{lastName}}</h2>
  {{/with}}
{{#if author}}
    <h1>{{firstName}} {{lastName}}</h1>
  {{else}}
    <h1>Unknown Author</h1>
  {{/if}}

{{#unless license}}
  <h3 class="warning">WARNING: This entry does not have a license!</h3>
  {{/unless}}
{{log "Look at me!"}}



{{else}}
  <p class="empty">No content</p>
{{/each}}
	</script>

	
		<script id="entry-template4" type="text/x-handlebars-template">
{{!--https://segmentfault.com/a/1190000000342636?from=androidqq   http://handlebarsjs.com/--}}
	</script>
	<script src="<%=basePath%>res/assets/handlebars/handlebars-v4.0.5.js"></script>

	<script type="text/javascript">
		$(function() {
			Handlebars.registerHelper('link', function(text, url) {
				text = Handlebars.Utils.escapeExpression(text);
				url = Handlebars.Utils.escapeExpression(url);

				var result = '<a href="' + url + '">' + text + '</a>';

				return new Handlebars.SafeString(result);
			});
			Handlebars.registerHelper('agree_button', function() {
				  return new Handlebars.SafeString(
				    "<button>I agree. I " + this.emotion + " " + this.name + "</button>"
				  );
				});
			console.log("Getting Started");
			var source = $("#entry-template1").html();
			var template = Handlebars.compile(source);
			var context  = {
						    body:'这是文章内容',
						    permalink: 'http://xx.com/xx',
						    comments:[{
						      title:'这篇文章不错，赞一个'
						    },{
						      title:'好文要顶！'
						    }]
						  }
			var html = template(context);
			console.log(html)
		});
	</script>
</body>
</html>