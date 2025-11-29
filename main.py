from fastapi import FastAPI, HTTPException
import uvicorn

app = FastAPI()

@app.get("/hello")
def say_hello(name: str | None = None):
    # ❌ If name is missing → return 400 error
    if name is None:
        raise HTTPException(
            status_code=400,
            detail="Missing required query parameter: name"
        )

    return {"message": f"Hello {name}!"}

def main():
    uvicorn.run("main:app", host="127.0.0.1", port=8000, reload=True)

if __name__ == "__main__":
    main()
