<%-- 
    Document   : js
    Created on : 23 mars 2018, 21:46:46
    Author     : tangu_000
--%>

<script src="<%= request.getContextPath() %>/template/js/common.js"></script>
		<script src="<%= request.getContextPath() %>/template/js/jquery.flexslider-min.js"></script>
		<script type="text/javascript">
			$(function() {
				$(document).ready(function() {
					$('.flexslider').flexslider({
						animation: "fade",
						slideshowSpeed: 4000,
						animationSpeed: 600,
						controlNav: false,
						directionNav: true,
						controlsContainer: ".flex-container" // the container that holds the flexslider
					});
				});
			});
		</script>