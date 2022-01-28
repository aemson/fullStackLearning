import React, {useEffect} from "react";

export default () => {

    let child: Window | null;
    const addChild = () => {
        child = window.open("https://www.google.com");
        // @ts-ignore
        /*const winClosed = setInterval(function () {
            if (child?.closed) {
                clearInterval(winClosed);
                foo();
            }
        }, 400);*/

        /*const closeChildSoon = setInterval(function () {
            console.log('closeChildSoon', child)
            if (child && !child.closed) {
                console.log('closedChild')
                child.close();
                clearInterval(closeChildSoon)
            }
        }, 1000)*/
    }

    const getListener = () =>
        (ev: BeforeUnloadEvent) => {
            ev.preventDefault();
            if (child && !child.closed) {
                child.close();
            }
        }


    const closeChild = () => child?.window.close()

    useEffect(() => {
        window.addEventListener("beforeunload", getListener);
        return () => window.removeEventListener("beforeunload", getListener);
    }, []);



    const foo = () => console.log("callback when child closed ")
    return (
        <>
            Welcome to testing
            <main>
                <button onClick={addChild}>Call child</button>
                <button onClick={closeChild}>Close child</button>
            </main>
        </>
    )
}


/**

 var win = window.open("http://www.google.com");
 var winClosed = setInterval(function () { if (win.closed) { clearInterval(winClosed); foo(); //Call your function here } }, 250);

 * */