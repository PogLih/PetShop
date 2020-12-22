
$(document).ready(function() {
	$.ajax({
		type: 'GET',
		dataType: 'json',
		contentType: "application/json",
		url: 'http://localhost:8080/api/billinfo/getall',
		success: function(result) {
			google.charts.load('current', {
				'packages': ['corechart']
			});
			google.charts.setOnLoadCallback(function() {
				drawChart(result);
			});
		}
	});
	function drawChart(result) {
		var data = new google.visualization.DataTable();
		data.addColumn('string', 'Sản phẩm: ');
		data.addColumn('number', 'Tổng sản phẩm: ');
		var dataArray = [];
		$.each(result, function(i, obj) {
			dataArray.push([obj.idproduct, obj.countitem]);
		});
		data.addRows(dataArray);

		var piechart_options = {
			title: 'Thống kế số lượng mua',
			width: 700,
			height: 600
		};
		var piechart = new google.visualization.PieChart(document.getElementById('piechart_div'));
		piechart.draw(data, piechart_options);

		var barchart_options = {
			title: 'Thống kế số lượng mua',
			width: 700,
			height: 600,
			legend: 'none'
		};
		var barchart = new google.visualization.BarChart(document.getElementById('barchart_div'));
		barchart.draw(data, barchart_options);
	}
});

