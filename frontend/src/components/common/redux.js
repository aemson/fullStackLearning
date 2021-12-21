

export const sendEmail = (data) => ({type: "SEND_EMAIL", payload: data})

export default function emailReducer(state = [], action){

    switch(action.type) {
        case "SEND_EMAIL":  return Object.assign({}, state, {
            email: action.payload
        });
        default: return state;
    }
}