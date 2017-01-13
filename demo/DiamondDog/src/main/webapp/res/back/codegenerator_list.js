$(function() {
	var data = [];

	var grid = $("#grid")
			.bootgrid(
					{
						pagination : 3,
						selection : true,
						multiSelect : true,
						formatters : {
							"quantity" : function(column, row) {
								return "<input id=\""
										+ row.id
										+ "-quantity\" type=\"text\" class=\"quantity\" value=\""
										+ row.quantity + "\" />";
							}
						}
					}).on(
					"loaded.rs.jquery.bootgrid",
					function(e) {
						// Resets the selected data array on reload, searching,
						// sorting or changing page
						data = [];

						grid.on("keyup", "input.quantity", function() {
							e.stopPropagation();

							// Array.first is an extension of bootgrid
							var $this = $(this), rowId = +$this.attr("id")
									.split("-")[0], // "+" to convert the a
							// string to an integer
							item = data.first(function(item) {
								return item.id === rowId;
							});
							if (item != null) {
								item.quantity = $this.val();
							}
						});
					})
			.on("selected.rs.jquery.bootgrid", function(e, selectedRows) {
				var row, quantity;
				for ( var i = 0; i < selectedRows.length; i++) {
					row = selectedRows[i];

					// Array.contains is an extension of bootgrid
					if (!data.contains(function(item) {
						return item.id === row.id;
					})) {
						quantity = grid.find("#" + row.id + "-quantity").val();
						data.push({
							id : row.id,
							quantity : quantity || 0
						});
					}
				}
			}).on("deselected.rs.jquery.bootgrid", function(e, deselectedRows) {
				var row;
				for ( var i = 0; i < deselectedRows.length; i++) {
					row = deselectedRows[i];
					for ( var j = 0; j < data.length; j++) {
						if (data[j].id === row.id) {
							data.splice(j, 1);
							return;
						}
					}
				}
			});

	$("#send").on("click", function() {
		var params = $.param({
			"" : data
		});
		alert(decodeURIComponent(params));
	});
});