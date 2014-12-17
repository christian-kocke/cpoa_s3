<!DOCTYPE html>
<html>
    <head>
        <title>bootstrap datepicker examples</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS and bootstrap datepicker CSS used for styling the demo pages-->
        <link rel="stylesheet" href="css/foundation-datepicker.css">
        <link rel="stylesheet" href="css/foundation.min.css">

    <link rel="stylesheet" href="css/app.css">
    <script src="js/vendor/modernizr.js"></script>
    <script src="js/vendor/jquery.js"></script>
    </head>
    <body>

    <div class="row">
        <div class="large-6 centered-large column">
            
                <table class="table">
                    <thead>
                        <tr>
                            <th>Check in:
                                <input type="text" class="fdatepicker" value="" id="dpd1">
                            </th>
                            <th>Check out:
                                <input type="text" class="fdatepicker" value="" id="dpd2">
                            </th>
                        </tr>
                    </thead>
                </table>            
        </div>
    </div>
        <!-- Load jQuery and bootstrap datepicker scripts -->
        <script src="js/vendor/fastclick.js"></script>
        <script src="js/foundation.min.js"></script>
        
        <script src="js/foundation-datepicker.js"></script>
        <script type="text/javascript">
            // When the document is ready
            $(document).ready(function () {
                
                $('.fdatepicker').fdatepicker({
                    format : 'dd/mm/yyyy'
                });  

                var nowTemp = new Date();
                var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);
             
                var checkin = $('#dpd1').fdatepicker({
                    onRender: function (date) {
                        return date.valueOf() < now.valueOf() ? 'disabled' : '';
                    }
                }).on('changeDate', function (ev) {
                    if ((ev.date.valueOf() > checkout.date.valueOf())) {
                        var newDate = new Date(ev.date)
                        newDate.setDate(newDate.getDate() + 1);
                        checkout.update(newDate);
                    }
                    checkin.hide();
                    $('#dpd2')[0].focus();
                }).data('datepicker');
                var checkout = $('#dpd2').fdatepicker({
                    onRender: function (date) {
                        return date.valueOf() <= checkin.date.valueOf() ? 'disabled' : '';
                    }
                }).on('changeDate', function (ev) {
                    checkout.hide();
                }).data('datepicker');
            });
        </script>
    </body>
</html>
