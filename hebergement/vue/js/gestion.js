$(document).foundation({
  abide : {
    live_validate : true,
    focus_on_invalid : true,
    error_labels: true, // labels with a for="inputId" will recieve an `error` class
    timeout : 1000,
    patterns : {
      alpha: /^[a-zA-Z]+$/,
        alpha_numeric : /^[a-zA-Z0-9]+$/,
        integer: /^[-+]?\d+$/,
        number: /^[-+]?[1-9]\d*$/,

        // amex, visa, diners
        card : /^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\d{3})\d{11})$/,
        cvv : /^([0-9]){3,4}$/,

        // http://www.whatwg.org/specs/web-apps/current-work/multipage/states-of-the-type-attribute.html#valid-e-mail-address
        email : /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/,

        url: /(https?|ftp|file|ssh):\/\/(((([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-zA-Z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-zA-Z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-zA-Z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-zA-Z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-zA-Z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-zA-Z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?/,
        // abc.de
        domain: /^([a-zA-Z0-9]([a-zA-Z0-9\-]{0,61}[a-zA-Z0-9])?\.)+[a-zA-Z]{2,6}$/,

        datetime: /([0-2][0-9]{3})\-([0-1][0-9])\-([0-3][0-9])T([0-5][0-9])\:([0-5][0-9])\:([0-5][0-9])(Z|([\-\+]([0-1][0-9])\:00))/,
        // YYYY-MM-DD
        date: /(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))/,
        // HH:MM:SS
        time : /(0[0-9]|1[0-9]|2[0-3])(:[0-5][0-9]){2}/,
        dateISO: /\d{4}[\/\-]\d{1,2}[\/\-]\d{1,2}/,
        // MM/DD/YYYY
        month_day_year : /(0[1-9]|1[012])[- \/.](0[1-9]|[12][0-9]|3[01])[- \/.](19|20)\d\d/,

        // #FFF or #FFFFFF
        color: /^#?([a-fA-F0-9]{6}|[a-fA-F0-9]{3})$/
    },
    validators: {
      diceRoll: function(el, required, parent) {
        var possibilities = [true, false];
        return possibilities[Math.round(Math.random())];
      },
      isAllowed: function(el, required, parent) {
        var a = $("#dpd1").val();
        var b = $(el).val();
        return  a < b;
      }
    }
  }
});

$(document).ready( function () {
    $('#table').DataTable({
    	"dom" : 'l<"large-3 column column_filter right">frtip',
    	"oLanguage": {
				"sEmptyTable": "Aucun VIP doit être placer",
				"sSearch": "Recherche",
				"sLengthMenu": 'Afficher <select>'+
		        '<option value="10">10</option>'+
		        '<option value="20">20</option>'+
		        '<option value="30">30</option>'+
		        '<option value="40">40</option>'+
		        '<option value="50">50</option>'+
		        '<option value="-1">Tous</option>'+
		        '</select> ',
		    "sInfoFiltered": " - ( filtrer à partir de _MAX_ enregistrements )",
		    "sInfo": "Un total de _TOTAL_ enregistrement(s) afficher (de _START_ à _END_)",
				"oPaginate": {
		        "sNext": "Suivant",
		        "sPrevious": "Précédent"
		      }
		},
        "serverSide": true,
        "processing": true,
        "ajax" : {
            "type": "POST",
            "dataType": "json",
            "url": "response.php",
            "data": { action : "display" }
        },
	    initComplete: function () {
            var api = this.api();
 
            api.columns().indexes().flatten().each( function ( i ) {
                var column = api.column( 1 );
                var select = $('<label for="select" class="filter_label">Rôle</label><select id="select"><option value=""></option></select>')
                    .appendTo( $(".column_filter").empty() )
                    .on( 'change', function () {
                        var val = $.fn.dataTable.util.escapeRegex(
                            $(this).val()
                        );
 
                        column
                            .search( val ? '^'+val+'$' : '', true, false )
                            .draw();
                    } );
 
                column.data().unique().sort().each( function ( d, j ) {
                    select.append( '<option value="'+d+'">'+d+'</option>' )
                } );

            } );
        }	
    });


    var data2 = {
              "action": "display2"
    };
    var table2 = $('#table2').DataTable({
        "dom" : 'lfrtip',
        "oLanguage": {
                "sEmptyTable": "Aucun hebergement ne correspond au critères",
                "sSearch": "Recherche",
                "sLengthMenu": 'Afficher <select>'+
                '<option value="10">10</option>'+
                '<option value="20">20</option>'+
                '<option value="30">30</option>'+
                '<option value="40">40</option>'+
                '<option value="50">50</option>'+
                '<option value="-1">Tous</option>'+
                '</select> ',
            "sInfoFiltered": " - ( filtrer à partir de _MAX_ enregistrements )",
            "sInfo": "Un total de _TOTAL_ enregistrement(s) afficher (de _START_ à _END_)",
                "oPaginate": {
                "sNext": "Suivant",
                "sPrevious": "Précédent"
              }
        },
        "serverSide": true,
        "processing": true,
        "ajax" : {
            "type": "POST",
            "dataType": "json",
            "url": "response.php",
            "data": (function() {
                        var data2 = {"action" : "display2"};
                        var $fields = $(".form1 input");
                        var isValid;
                        $fields.each(function() {
                           if (!$.trim($(this).val())) {
                               isValid = false;
                           }
                        });
                        if(isValid != false){
                            $("#start").val($(".form1 input[name=debut]").val());
                            $("#end").val($(".form1 input[name=fin]").val());
                            data2 = $(".form1").serialize() + "&" + $.param(data2);
                        }else{
                            $.param(data2);
                        }
                        return data2;
                    })
        }
    });
    
    function isJson(str) {
        try {
            JSON.parse(str);
        } catch (e) {
            return false;
        }
        return true;
    }


	$("#tlogement").change(function() {
		if($(this).val() == "hotel"){
			$(".chambre").show();
		}else{
			$(".chambre").hide();
		}
	});
    // datepicker 
    $('#dpd1').fdatepicker({
        format : 'dd/mm/yyyy',
        startDate : '14/05/2015',
        endDate : '23/05/2015',
    });
    $('#dpd2').fdatepicker({
        format : 'dd/mm/yyyy',
        startDate : '15/05/2015',
        endDate : '24/05/2015',
    });    

    var nowTemp = new Date();
    var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);
 
    var checkin = $('#dpd1').fdatepicker({
        onRender: function (date) {
            return date.valueOf() < now.valueOf() ? 'disabled' : '';
        }
    }).on('changeDate', function (ev) {
    	$("#dpd2").fdatepicker('setStartDate', (ev.date.getDate()+1)+"/05/2015");
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
            return date.valueOf() < checkin.date.valueOf() ? 'disabled' : '';
        }
    }).on('changeDate', function (ev) {
        checkout.hide();
    }).data('datepicker');



    
    var table1 = $('#table').DataTable();
    var table2 = $('#table2').DataTable();
    $('button.n1').hide();
    $('#table tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
            $('button.n1').hide();
        }
        else {
            table1.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
            $('button.n1').show();
        }
    } );

    // selection table final
    $('button.p').hide();
    $('#table2 tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
            $('button.p').hide();
        }
        else {
            table2.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
            $('button.p').show();
        }
    } );
 

 
    $('button.n1').click( function () {
        $("#guest").html("Veuillez spécifier les informations ci-dessous pour l'inviter <strong id='guest'>"+table1.cell('.selected', 0).data()+"</strong>");
    } );



	$(".sub-nav dd").click(function(){
		$(this).addClass("active");
		$(this).siblings().toggleClass("active", false);
        var current = "."+$(this).children("a").attr("id");
        $(current).siblings().hide(0, function(){
            $(current).addClass("large-centered large-5");
            $(current).siblings().removeClass("large-centered large-5");
        });
        $(current).show();
	});
    $("button.n2").hide();
    // test si le formulaire est vide
    var $fields = $(".form1 input, select");
    $fields.change(function(){
        var isValid;
        $fields.each(function() {
           if (!$.trim($(this).val())) {
               isValid = false;
           }
        });
        if(isValid != false){
            $("button.n2").show();
        }else{
            $("button.n2").hide();
        }  
    });
    $("ul.list").each(function() {
        $(this).load("response.php", { "action" : "service", "categorie" : $(this).attr('id') }, function(responseText){
            $(this).html(responseText.replace(/\"/g, ""));
        });
    });



	$(".next").click(function(){
        var current = parseInt($(this).val())-1;
		$(".step"+current).hide("slide", {direction : "left"}, 600);
		$(".step"+(current+1)).hide("slide", {direction : "right"}, 50, function(){
			$(".step"+(current+1)).css("visibility", "visible");
		});
		$(".step"+(current+1)).show("slide", {direction : "right"}, 600);
	});
	$(".previous").click(function(){
		var current = parseInt($(this).val())+1;
		$(".step"+current).hide("slide", {direction : "right"}, 600);
		$(".step"+(current-1)).show("slide", {direction : "left"}, 600);
	})
    
    $("#form1").on("submit", function(){
        table2.ajax.reload();
        return false;
    });

    $("#table2 tbody").on("click", "button.reveal", function() {
        var id = $(this).val();
        $('#myModal').foundation('reveal', 'open', {
            url: 'response.php',
            type: 'POST',
            data: {action: 'displayModal', id: id},
            dataFilter: function(data) {
                return data.replace(/\"/g, "");
            },
        });
    });

    $('#myModal').on("click", "a", function () {
        field = $(this).attr("href");
        if($(field).hasClass("active")){
            $(field).removeClass("active");
        }else{
            $(field).addClass("active");
            $("content.active").removeClass('active');
        }
    });

    $("#table").on("click", "tr", function() {
        if($(this).hasClass('selected')){
            $("#nom").val(table1.cell('.selected', 0).data());
        }else{
            $("#nom").val("");
        }
    });

    $("#table2").on("click", "tr", function() {
        if($(this).hasClass('selected')){
            $("#id").val($(this).children("td").children("button.button").val());
        }else{
            $("#id").val("");
        }
    });
});




