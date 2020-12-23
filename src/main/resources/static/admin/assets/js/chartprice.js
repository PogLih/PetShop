$(document).ready(function() {
	$.ajax({
		type: 'GET',
		dataType: 'json',
		contentType: "application/json",
		url: 'http://localhost:8080/api/bill/findall',
		success: function(result) {
			google.charts.load('current', {
				'packages': ['corechart']
			});
			google.charts.setOnLoadCallback(function() {
				drawChart1(result);
			});
		}
	});
	function drawChart1(result) {
		var data = new google.visualization.DataTable();
		data.addColumn('number', ': ');
		data.addColumn('number', 'Tổng tiền: ');
		var dataArray = [];
		
		$.each(result, function(i, obj) {
			
			dataArray.push([obj.date, obj.totalprice]);
		});
		data.addRows(dataArray);

		var barchart_options = {
			title: 'Thống kê tổng tiền từng tháng',
			width: 1200,
			height: 400,
			legend: 'none'
			
		};
		var barchart = new google.visualization.LineChart(document.getElementById('barchart_div'));
		barchart.draw(data, barchart_options);
	}
});


