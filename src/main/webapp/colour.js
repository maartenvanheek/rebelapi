less = {
    env: "development"
};
function changeColour(colour) {
    switch (colour) {
        case 'dev':
            less.modifyVars({
                '@dash': 'gray',
                '@black': 'black',
                '@text': 'black',
                '@edgeNode': 'lightblue',
                '@background': 'pink',
                '@external': 'lightgray',
                '@graphTitle': 'green',
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
                '@background': 'white',
                '@external': 'lightgray',
                '@graphTitle': 'black',
                '@fieldsBox': 'lightgray',
                '@fieldsText': 'black',
                '@uncertain': 'magenta',
                '@uncertain2': 'yellow'
            });
        }
    }

}