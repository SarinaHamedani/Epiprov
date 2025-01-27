const puppeteer = require('puppeteer-extra');

// add recaptcha plugin and provide it your 2captcha token
// 2captcha is the builtin solution provider but others work as well.
const RecaptchaPlugin = require('puppeteer-extra-plugin-recaptcha');
puppeteer.use(RecaptchaPlugin());

async function run() {
    const browser = await puppeteer.launch();
    const page = await browser.newPage();
    await page.solveRecaptchas();

    // await page.setUserAgent(
    //     'Mozialla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KTML, like Gecko) Chrome '
    // )

    await page.goto('https://chatgpt.com/');
    await page.waitForNetworkIdle();
    await page.screenshot({ path: 'sc.png' });

    browser.close();
}

run();