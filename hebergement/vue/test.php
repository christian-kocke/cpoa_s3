<!DOCTYPE html>
<html>
    <head>
        <title>bootstrap datepicker examples</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS and bootstrap datepicker CSS used for styling the demo pages-->
        <link rel="stylesheet" href="css/foundation-datepicker.css">
        <link rel="stylesheet" href="css/bootstrap.css">
    </head>
    <body>
    <div class="panel">
        <table class="table">
            <thead>
                <tr>
                    <th>Check in:
                        <input type="text" class="span2" value="" id="dpd1">
                    </th>
                    <th>Check out:
                        <input type="text" class="span2" value="" id="dpd2">
                    </th>
                </tr>
            </thead>
        </table>
    </div>
        <!-- Load jQuery and bootstrap datepicker scripts -->
        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/foundation-datepicker.js"></script>
        <script type="text/javascript">
            // When the document is ready
            $(document).ready(function () {
                
                $('.fdatepicker').fdatepicker();  
                var nowTemp = new Date();
                var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);
             
                var checkin = $('#dpd1').fdatepicker({
                    onRender: function (date) {
                        return date.valueOf() &lt; now.valueOf() ? 'disabled' : '';
                    }
                }).on('changeDate', function (ev) {
                    if ((ev.date.valueOf() &gt; checkout.date.valueOf())) {
                        var newDate = new Date(ev.date)
                        newDate.setDate(newDate.getDate() + 1);
                        checkout.update(newDate);
                    }
                    checkin.hide();
                    $('#dpd2')[0].focus();
                }).data('datepicker');
                var checkout = $('#dpd2').fdatepicker({
                    onRender: function (date) {
                        return date.valueOf() &lt;= checkin.date.valueOf() ? 'disabled' : '';
                    }
                }).on('changeDate', function (ev) {
                    checkout.hide();
                }).data('datepicker');
            });
        </script>
    </body>
</html>
