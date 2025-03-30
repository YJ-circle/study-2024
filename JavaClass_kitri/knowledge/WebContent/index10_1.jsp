<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>�ڽ� �׵θ�</title>
<!-- ���� ��Ÿ�� -->
<style>
/*
div{
background-image: url('./cat1.jpg');background-size: auto;width: 500px;height: 300px;background-repeat: no-repeat;
}
*/

	hr{
	}
	.box2{

		border-radius: 30px;
	}
	.box3{
		border: 3px dashed #333;
		border-top-left-radius: 30px;

	}
	p{

		background: rgba(255, 255, 255, 0.3);
	}
	
	#chart{
	width: 500px;
	height: 300px;}

</style>
<link rel="stylesheet" href="https://naver.github.io/billboard.js/release/latest/dist/theme/datalab.min.css">
<script src="https://naver.github.io/billboard.js/release/latest/dist/billboard.pkgd.min.js"></script>
<script src="https://d3js.org/d3.v7.min.js"></script>
</head>
<body>
	<div class="box1">
		<p>
		It is a long established fact <br>
		that a reader will be distracted
		</p>
	</div>
	<hr>
	<div class="box2">
		<p>
		It is a long established fact <br>
		that a reader will be distracted
		</p>
	</div>	
	<hr>
	<div class="box3">
		<p>
		It is a long established fact <br>
		that a reader will be distracted
	</div>
	<div id="chart"/>		
<script>
//https://naver.github.io/billboard.js/demo/#Axis.AxisLabelPosition
var chart = bb.generate({
    bindto: "#chart",
    data: {
        type: "line",
        columns: [
            ["����1", 30000, 20000, 10000, 17000, 15000, 35000],
            ["����2", 13000, 10000, 14000, 35000, 11000, 50000]
        ]
    },
    axis: {
        x: {
          label: {
        	  text: "���� �̸�",
        	  position: "outer-center"},
          type: "category",
          categories: ["9�� 1��", "9�� 5��", "9�� 10��","9�� 15��","9�� 20��", "����!!"]
        },
        y: {
            tick: {
            	 format: function(x) { return d3.format(",")(x)+"��"; }
              },
        	label: {
        		text: "����",
        		position: "outer-middle"
        	}
        }
    }
});
</script>
</body>


</html>