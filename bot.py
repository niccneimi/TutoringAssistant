import asyncio

from aiogram import Router, Bot, Dispatcher
from aiogram.types import Message, WebAppInfo, KeyboardButton, ReplyKeyboardMarkup
from aiogram.filters import CommandStart
from aiogram.enums import ParseMode
from aiogram.utils.keyboard import InlineKeyboardBuilder


from config import *
import logging


router = Router()

@router.message(CommandStart())
async def start(message: Message) -> None:
    await message.reply("Hello!\nI'm Tutoring Bot!", reply_markup=ReplyKeyboardMarkup(
        keyboard=[
            [
                KeyboardButton(text="Open Web App", web_app=WebAppInfo(url="https://tb-channel-ref-horhi.amvera.io/referral/1234"))
            ]
        ],
        resize_keyboard=True
    ))

async def main() -> None:
    bot = Bot(TOKEN)

    dp = Dispatcher()
    dp.include_router(router)

    await bot.delete_webhook(True)
    await dp.start_polling(bot)

if __name__ == "__main__":
    logging.basicConfig(level=logging.INFO)
    asyncio.run(main())