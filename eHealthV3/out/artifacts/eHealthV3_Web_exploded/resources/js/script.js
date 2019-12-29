/**
 * Created by salahtobok on 22/03/17.
 */

$('#modal').on('show.bs.modal', function () {
    $(this).find('.modal-body').css({
        width:'auto', //probably not needed
        height:'auto', //probably not needed
        'max-height':'100%'
    });
});