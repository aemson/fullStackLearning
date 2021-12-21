import React, {useEffect, useState} from 'react'

const crustType: string[] = ['thick', 'thin', 'gluten'];

type userType = {
    created_at: string,
    created_by: string,
    user_id: string,
    user_name: string,
    user_password: string,
    user_role: string,
}
export default () => {

    const [selectedCrust, setSelectedCrust] = useState("thick")
    const changeCrust = (crust: string) => {
        setSelectedCrust(crust)
    }
    const [users, setUsers] = useState<userType[]>([]);

    useEffect(() => {

        fetch('/users')
            .then(response => response.json())
            .then(data => setUsers(data));
    }, [])

    console.log(users)
    return (<>
        <form>
            <fieldset>
                <legend> List Users</legend>
                {users.map((user, index) =>
                    <label className="block" key={index}>
                        <input type="radio" name="crust" value={user.user_id} onChange={() => changeCrust(user.user_id)}
                               checked={selectedCrust === user.user_id}/>
                        {user.user_name}
                    </label>
                )}
            </fieldset>
        </form>
    </>)
}