$(document).ready(function() {
	$.ajax({
		type: 'GET',
		dataType: 'json',
		contentType: "application/json",
		url: 'http://localhost:8080/api/bill/countstatus',
		success: function(result) {
			google.charts.load('current', {
				'packages': ['table']
			});
			google.charts.setOnLoadCallback(function() {
				drawChart2(result);
			});
		}
	});
	function drawChart2(result) {
		var data = new google.visualization.DataTable();
		data.addColumn('number', 'Trạng thái ');
		data.addColumn('number', 'Số lượng: ');
		
		var dataArray = [];
		
		$.each(result, function(i, obj) {
			
			dataArray.push([obj.status, obj.id]);
			
		});
		
		data.addRows(dataArray);

		var columnchart_options = {
			title: 'Thống kê trạng thái các hoá đơn',
			title: 'Trạng thái 1 là chưa xử lí, 2 là đang xử lí, 3 là Đã xử lí, 4 là huỷ hàng',
			width: 600,
			height: 400,
			
			
			
		};
		var columnchart = new google.visualization.Table(document.getElementById('status_div'));
		columnchart.draw(data, columnchart_options);
	}
});


