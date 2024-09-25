<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>박스 테두리</title>
<!-- 내부 스타일 -->
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
            ["게임1", 30000, 20000, 10000, 17000, 15000, 35000],
            ["게임2", 13000, 10000, 14000, 35000, 11000, 50000]
        ]
    },
    axis: {
        x: {
          label: {
        	  text: "게임 이름",
        	  position: "outer-center"},
          type: "category",
          categories: ["9월 1일", "9월 5일", "9월 10일","9월 15일","9월 20일", "오늘!!"]
        },
        y: {
            tick: {
            	 format: function(x) { return d3.format(",")(x)+"원"; }
              },
        	label: {
        		text: "가격",
        		position: "outer-middle"
        	}
        }
    }
});
</script>
</body>


</html>