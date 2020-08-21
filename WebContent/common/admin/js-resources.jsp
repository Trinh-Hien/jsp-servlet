<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<script src="<c:url value="/resources/admin/js/bootstrap.js" />"></script>
    <script src="<c:url value="/resources/admin/js/jquery.dcjqaccordion.2.7.js" />"></script>
    <script src="<c:url value="/resources/admin/js/scripts.js" />"></script>
    <script src="<c:url value="/resources/admin/js/jquery.slimscroll.js" />"></script>
    <script src="<c:url value="/resources/admin/js/jquery.nicescroll.js" />"></script>
    <script src="<c:url value="/resources/admin/js/jquery.scrollTo.js" />"></script>
    <!-- calendar -->
    <script type="text/javascript" src="<c:url value="/resources/admin/js/monthly.js" />"></script>
    <script type="text/javascript">
        $(window).load(function() {

            $('#mycalendar').monthly({
                mode: 'event',

            });

            $('#mycalendar2').monthly({
                mode: 'picker',
                target: '#mytarget',
                setWidth: '250px',
                startHidden: true,
                showTrigger: '#mytarget',
                stylePast: true,
                disablePast: true
            });

            switch (window.location.protocol) {
                case 'http:':
                case 'https:':
                    // running on a server, should be good.
                    break;
                case 'file:':
                    alert('Just a heads-up, events will not work when run locally.');
            }

        });
    </script>
    <!-- //calendar -->
    <script type="application/x-javascript">
        addEventListener("load", function() {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>