less = {
    env: "development"
};
function changeColor(color) {
    switch (color) {
        case 'dev':
            less.modifyVars({
                '@dash': 'gray',
                '@black': 'black',
                '@text': 'black',
                '@edgeNode': 'white',
                '@background': 'white',
                '@external': 'lightgray',
                '@graphTitle': 'black',
                '@fieldsBox': 'lightgray',
                '@fieldsText': 'black',
                '@uncertain': 'magenta',
                '@uncertain2': 'yellow'
            });
            break;
        default: {
            less.modifyVars({
                '@dash': 'gray',
                '@black': 'black',
                '@text': 'black',
                '@edgeNode': 'white',
                '@background': 'pink',
                '@external': 'lightgray',
                '@graphTitle': 'green',
                '@fieldsBox': 'gray',
                '@fieldsText': 'lightblue',
                '@uncertain': 'magenta',
                '@uncertain2': 'yellow'
            });
        }
    }

}